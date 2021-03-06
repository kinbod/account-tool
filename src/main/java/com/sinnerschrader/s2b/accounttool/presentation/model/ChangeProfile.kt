package com.sinnerschrader.s2b.accounttool.presentation.model

import com.sinnerschrader.s2b.accounttool.logic.entity.User
import org.apache.commons.lang3.StringUtils

import java.io.Serializable


/**
 * Form Bean for handling Profile changes
 */
class ChangeProfile(
    var changePublicKey: String = "",
    var changePhones: String = "",
    var changePassword: String = "",
    var oldPassword: String = "",
    var password: String = "",
    var passwordRepeat: String = "",
    var telephone: String = "",
    var mobile: String = "",
    var publicKey: String = ""
) : Serializable {

    constructor(user: User) : this(
        telephone = user.telephoneNumber,
        mobile = user.mobile,
        publicKey = user.szzPublicKey ?: ""
    )

    fun createUserEntityFromForm(persistentUser: User) =
        persistentUser.copy(
            telephoneNumber = telephone.trim(),
            mobile = mobile.trim(),
            szzPublicKey = publicKey.trim())

    val isPasswordChange = changePassword.isNotBlank()
    val isPhoneChange = changePhones.isNotBlank()
    val isPublicKeyChange = changePublicKey.isNotBlank()
}