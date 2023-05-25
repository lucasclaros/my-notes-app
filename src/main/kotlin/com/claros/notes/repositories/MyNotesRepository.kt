package com.claros.notes.repositories

import com.claros.notes.models.NoteModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface MyNotesRepository: JpaRepository<NoteModel, UUID> {

}