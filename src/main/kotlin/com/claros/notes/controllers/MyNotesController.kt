package com.claros.notes.controllers

import com.claros.notes.dtos.MyNotesDto
import com.claros.notes.models.NoteModel
import com.claros.notes.services.MyNotesService
import jakarta.validation.Valid
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("/notes")
class MyNotesController (private val myNotesService: MyNotesService) {
    @PostMapping
    fun saveNote(@RequestBody @Valid myNotesDto: MyNotesDto) : ResponseEntity<Any> {
        var myNotesModel = NoteModel(null, myNotesDto.name, myNotesDto.description)
        return ResponseEntity.status(HttpStatus.CREATED).body(myNotesService.save(myNotesModel))
    }
    
    @GetMapping
    fun getAllNotes(): ResponseEntity<List<NoteModel>> {
        return ResponseEntity.status(HttpStatus.OK).body(myNotesService.findAll())
    }
    @GetMapping("/{id}")
    fun getNoteByID(@PathVariable(value = "id") id: UUID): ResponseEntity<Any> {
        var note: Optional<NoteModel> = myNotesService.findByID(id)

        if (!note.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Num achei o caba não")
        }
        return ResponseEntity.status(HttpStatus.OK).body(note.get())
    }

    @DeleteMapping("/{id}")
    fun deleteNoteByID(@PathVariable(value = "id") id: UUID): ResponseEntity<Any> {
        var note: Optional<NoteModel> = myNotesService.findByID(id)

        if (!note.isPresent) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Num achei o caba não")
        }
        myNotesService.delete(note.get())
        return ResponseEntity.status(HttpStatus.OK).body("Executei o caba chefia")
    }

    @PutMapping("/{id}")
    fun updateNoteByID(@PathVariable(value = "id") id: UUID, @RequestBody @Valid myNotesDto: MyNotesDto): ResponseEntity<Any> {
        var note: Optional<NoteModel> = myNotesService.findByID(id)

        if (!note.isPresent) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Num achei o caba não")
        }
        var newNote = note.get()
        newNote.name = myNotesDto.name
        newNote.description = myNotesDto.description
        return ResponseEntity.status(HttpStatus.OK).body(myNotesService.save(newNote))
    }
}