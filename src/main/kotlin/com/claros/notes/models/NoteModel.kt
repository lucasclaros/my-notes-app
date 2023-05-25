package com.claros.notes.models


import jakarta.persistence.*
import java.io.Serializable
import java.util.*

@Entity
@Table(name = "notes")
class NoteModel(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: UUID? = null,

    @Column(name = "name", nullable = false, unique = true, length = 30)
    var name: String,

    @Column(name = "description", nullable = false, unique = true, length = 100)
    var description: String
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1L
    }
}