package com.nhgirls.pockit.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nhgirls.pockit.api.Service
import com.nhgirls.pockit.data.Cart
import com.nhgirls.pockit.utils.safeEnqueue
import timber.log.Timber

class CartViewModel : ViewModel() {
    private val _cartList = MutableLiveData<List<Cart>>()
    val cartList: LiveData<List<Cart>>
        get() = _cartList

    private val _startDeliveryDate = MutableLiveData<Int>(13)
    val startDeliveryDate: LiveData<Int>
        get() = _startDeliveryDate

    private val _endDeliveryDate = MutableLiveData<Int>(15)
    val endDeliveryDate: LiveData<Int>
        get() = _endDeliveryDate

    private val _dayDeliveryDate = MutableLiveData<String>("화")
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
        Service.service.getCarts().safeEnqueue(
            {},
            { _cartList.value = it.data.products
                _deliveryCharge.value = it.data.deliveryCharge
            },
            { Timber.d("${it.code()} ${it.message()}}") }
        )
        calculateTotalPrice()
        _deliveryCharge.value = 0
    }

    fun toggle(cart: Cart) {
        findCart(cart.id)?.let {
            val newCart = Cart(it.id, it.image, it.name, it.price, it.count, !(it.checked))
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
        findCart(cart.id)?.let {
            val decreasedCount = it.count - 1
            if (decreasedCount == 0) {
                remove(cart)
            } else {
                val newCart = Cart(it.id, it.image, it.name, it.price, decreasedCount, it.checked)
                replaceCart(it, newCart)
            }
        }
        calculateTotalPrice()
    }

    fun increaseCount(cart: Cart) {
        findCart(cart.id)?.let {
            val newCart = Cart(it.id, it.image, it.name, it.price, it.count + 1, it.checked)
            replaceCart(it, newCart)
        }
    }

    private fun findCart(id: Int): Cart? {
        return _cartList.value?.find { it.id == id }
    }

    private fun replaceCart(oldCart: Cart, newCart: Cart) {
        val cartList = cartList.value?.toMutableList()

        cartList?.forEachIndexed { index, cart ->
            if (cart.id == newCart.id) {
                cartList[index] = newCart
            }
            _cartList.value = cartList
        }
    }

    fun checkAll(ifCheck: Boolean) {
        _cartList.value =
            cartList.value?.map { Cart(it.id, it.image, it.name, it.price, it.count, ifCheck) }
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
            ?.sum()  ?: ZERO_WON
    }

    companion object{
        private const val ZERO_WON = 0
    }
}
