package com.example.database.users

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object User: Table("users") {
    //private val id = User.primaryKey
    private val login = User.varchar("login", 50)
    private val password = User.varchar("password", 50)
    private val token = User.varchar("token", 100)

    fun insert(userDTO: UserDTO) {
        transaction {
            User.insert {
                it[login] = userDTO.login
                it[password] = userDTO.password
                it[token] = userDTO.token
            }
        }
    }

    fun fetchUser(login: String): UserDTO? {
        return try {
            transaction {
                val user = User.select { User.login.eq(login) }.single()
                UserDTO(
                    login = user[User.login],
                    password = user[password],
                    token = user[token]
                )
            }

        } catch (e: Exception) {
            null
        }
    }
}