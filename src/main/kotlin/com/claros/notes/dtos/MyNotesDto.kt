package com.claros.notes.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

class MyNotesDto (
    @NotBlank
    @Size(max = 30)
    var name: String,
    @Size(max = 100)
    var description: String
) {
}