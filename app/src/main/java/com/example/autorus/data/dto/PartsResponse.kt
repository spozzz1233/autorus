package com.example.autorus.data.dto

import com.example.autorus.data.network.Response
import com.example.autorus.domain.model.Parts

class PartsResponse(val results: ArrayList<Parts>): Response()
