package com.claros.notes.services

import com.claros.notes.models.NoteModel
import com.claros.notes.repositories.MyNotesRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class MyNotesService (private val myNotesRepository: MyNotesRepository) {
    @Transactional
    fun save(myNotesModel: NoteModel): NoteModel {
        return myNotesRepository.save(myNotesModel)
    }

    fun findAll(): List<NoteModel>? {
        return myNotesRepository.findAll()
    }

    fun findByID(id: UUID): Optional<NoteModel> {
        return myNotesRepository.findById(id)
    }

    @Transactional
    fun delete(note: NoteModel) {
        return myNotesRepository.delete(note)
    }
}