package com.example.autorus.data.dto

import com.example.autorus.data.network.Response
import com.example.autorus.domain.model.Part

class PartsResponse(val results: List<Part>): Response()
