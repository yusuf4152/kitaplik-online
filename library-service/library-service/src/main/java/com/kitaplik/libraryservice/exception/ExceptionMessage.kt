package com.kitaplik.libraryservice.exception;


data class ExceptionMessage constructor(
        val timestamp: String,
        val status: Int,
        val error: String,
        val message: String,
        val path: String
)
