package org.example.extensions

import com.damo.proto.Account
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*

fun String.readFromDisk(): Result<Account> =

    kotlin.runCatching {
        FileInputStream(this).use { fs ->
            Account.parseFrom(fs)
        }
    }

fun String.writeToDisk(account: Account): Result<Unit> =

    kotlin.runCatching {
        account.writeTo(FileOutputStream(this))
    }

fun String.fileNameSuffix(): String = "$this${UUID.randomUUID()}"