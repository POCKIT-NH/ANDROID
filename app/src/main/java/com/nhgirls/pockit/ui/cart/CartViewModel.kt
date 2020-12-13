package com.nhgirls.pockit.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nhgirls.pockit.data.Cart
import com.nhgirls.pockit.data.DummyContainer

class CartViewModel : ViewModel() {
    private val _cartList = MutableLiveData<List<Cart>>()
    val cartList: LiveData<List<Cart>>
        get() = _cartList

    private val _startDeliveryDate = MutableLiveData<Int>(12)
    val startDeliveryDate: LiveData<Int>
        get() = _startDeliveryDate

    private val _endDeliveryDate = MutableLiveData<Int>(16)
    val endDeliveryDate: LiveData<Int>
        get() = _endDeliveryDate

    private val _dayDeliveryDate = MutableLiveData<String>("수")
    val dayDeliveryDate: LiveData<String>
        get() = _dayDeliveryDate

    private val _ifAllChecked = MutableLiveData<Boolean>(false)
    val ifAllChecked: LiveData<Boolean>
        get() = _ifAllChecked

    private val _totalPrice = MutableLiveData(0)
    val totalPrice: LiveData<Int>
        get() = _totalPrice

    private val _deliveryCharge = MutableLiveData<Int>()
    val deliveryCharge: LiveData<Int>
    get() = _deliveryCharge


    init {
        _cartList.value = DummyContainer.getDummyCarts()
        calculateTotalPrice()
        // todo 배송비 받아오기 코드 수정하기
        _deliveryCharge.value = 0
    }

    fun toggle(cart: Cart) {
        findCart(cart.image)?.let {
            val newCart = Cart(it.image, it.name, it.price, it.count, !(it.checked))
            replaceCart(it, newCart)
        }
        checkIfAllSelected()
    }


    fun remove(cart: Cart) {
        val cartList = cartList.value?.toMutableList()
        cartList?.remove(cart)
        _cartList.value = cartList
        checkIfAllSelected()
    }

    fun decreaseCount(cart: Cart) {
        findCart(cart.image)?.let {
            val decreasedCount = it.count - 1
            if (decreasedCount == 0) {
                remove(cart)
            } else {
                val newCart = Cart(it.image, it.name, it.price, decreasedCount, it.checked)
                replaceCart(it, newCart)
            }
        }
        calculateTotalPrice()
    }

    fun increaseCount(cart: Cart) {
        findCart(cart.image)?.let {
            val newCart = Cart(it.image, it.name, it.price, it.count + 1, it.checked)
            replaceCart(it, newCart)
        }
    }

    private fun findCart(image: String): Cart? {
        return _cartList.value?.find { it.image == image }
    }

    private fun replaceCart(oldCart: Cart, newCart: Cart) {
        val cartList = cartList.value?.toMutableList()

        cartList?.forEachIndexed { index, cart ->
            if (cart.image == newCart.image) {
                cartList[index] = newCart
            }
            _cartList.value = cartList
        }
    }

    fun checkAll(ifCheck: Boolean) {
        _cartList.value =
            cartList.value?.map { Cart(it.image, it.name, it.price, it.count, ifCheck) }
    }

    fun checkIfAllSelected() {
        val ifCheckedList = _cartList.value?.map { it.checked }
        _ifAllChecked.value = if (ifCheckedList != null && ifCheckedList.isNotEmpty()) {
            ifCheckedList.reduce { acc, checked -> acc.and(checked) }
        } else {
            false
        }

    }

    fun calculateTotalPrice() {
        _totalPrice.value = _cartList.value
            ?.filter { it.checked }
            ?.map { it.price * it.count }
            ?.sum()
    }
}
