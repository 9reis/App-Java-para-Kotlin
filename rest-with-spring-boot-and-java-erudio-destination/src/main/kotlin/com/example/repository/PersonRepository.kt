package com.example.repository

import br.com.erudio.model.Person
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person?, Long?>