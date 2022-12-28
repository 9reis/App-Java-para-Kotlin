package br.com.erudio.repository

import br.com.erudio.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person?, Long?>

// Operador de chamada segura
// fun mstr(value String?) = if(value != null) value?.length else null