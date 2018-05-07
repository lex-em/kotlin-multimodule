package ru.reliabletech.kotlin.multiplatform.web.back.user.domain

import ru.reliabletech.kotlin.multiplatform.web.domain.UUID
import javax.persistence.Entity
import javax.persistence.Id

/**
 * User
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
@Entity
data class User(@field:Id var id: UUID, var login: String, var password: String)