package com.nhgirls.pockit.data.response

import com.google.gson.annotations.SerializedName

data class Header (
    val Trtm: String = "050936",
    val Rsms: String = "정상처리 되었습니다.",
    val ApiNm: String = "ReceivedTransferAccountNumber",
    val IsTuno: String = "PYmrlCalD0pszqC",
    @SerializedName("Tsymd")
    val date: String = "20201214",
    val FintechApsno:String =  "001",
    val Iscd: String = "000750",
    val Rpcd: String = "00000",
    val ApiSvcCd: String =  "DrawingTransferA"
)