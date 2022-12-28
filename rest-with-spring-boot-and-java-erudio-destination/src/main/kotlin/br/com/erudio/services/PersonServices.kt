package br.com.erudio.services

import br.com.erudio.exception.ResourceNotFoundException
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonServices {
    @Autowired
    var repository: PersonRepository? = null
    fun create(person: Person?): Person {
        return repository.save(person)
    }

    fun findAll(): List<Person> {
        return repository.findAll()
    }

    fun findById(id: Long?): Person {
        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
    }

    fun update(person: Person): Person {
        val entity: Person = repository.findById(person.getId())
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        entity.setFirstName(person.getFirstName())
        entity.setLastName(person.getLastName())
        entity.setAddress(person.getAddress())
        entity.setGender(person.getGender())
        return repository.save(entity)
    }

    fun delete(id: Long?) {
        val entity: Person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        repository.delete(entity)
    }
}