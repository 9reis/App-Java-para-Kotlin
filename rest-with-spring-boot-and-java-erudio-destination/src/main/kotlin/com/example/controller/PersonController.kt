package com.example.controller

import br.com.erudio.model.Person

@RestController
@RequestMapping("/person")
class PersonController {
    @Autowired
    private val service: PersonServices? = null
    @GetMapping
    fun findAll(): List<Person> {
        return service.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long?): Person {
        return service.findById(id)
    }

    @PostMapping
    fun create(@RequestBody person: Person?): Person {
        return service.create(person)
    }

    @PutMapping
    fun update(@RequestBody person: Person?): Person {
        return service.update(person)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long?): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}