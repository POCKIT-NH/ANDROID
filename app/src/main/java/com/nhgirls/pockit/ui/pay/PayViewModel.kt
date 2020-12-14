package com.nhgirls.pockit.ui.pay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nhgirls.pockit.data.Card

class PayViewModel : ViewModel() {
    private val _cardList = MutableLiveData<List<Card>>()
    val cardList: LiveData<List<Card>>
        get() = _cardList

    private val _totalPrice = MutableLiveData<Int>()
    val totalPrice: LiveData<Int>
        get() = _totalPrice

    init {
        _cardList.value = getCardList()
    }

    private fun getCardList(): List<Card> = listOf(
        Card(0, "NH농협", "**** **** **** 4540"),
        Card(1, "NH농협", "**** **** **** 4540")
    )

    fun requestPay(
        customerName: String,
        customerPhone: String,
        addressCode: Int,
        address: String,
        addressDetail: String,
        memo: String
    ) {
        // todo 서버 요청 구현
    }

    fun setTotalPrice(totalPrice: Int) {
        totalPrice?.let { _totalPrice.value = it }
    }

    fun checkCard(card: Card) {
        cardList.value?.filter { it.id == card.id }
            ?.map {
                val newCard = Card(it.id, it.company, it.number, !(it.isChecked))
                replace(it, newCard)
            }

    }

    private fun replace(oldCard: Card, newCard: Card) {
        val cardList = cardList.value?.toMutableList()
        cardList?.forEachIndexed { index, card ->
            if (card.id == oldCard.id) {
                cardList[index] = newCard
                _cardList.value = cardList
            }
        }
    }
}