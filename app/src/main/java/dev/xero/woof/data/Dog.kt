package dev.xero.woof.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.xero.woof.R

data class Dog (
	@DrawableRes val imageResID: Int,
	@StringRes val nameResID: Int,
	@StringRes val hobbiesResID: Int,
	val age: Int
)

val dogs = listOf<Dog>(
	Dog(
		imageResID = R.drawable.koda,
		nameResID = R.string.dog_name_1,
		hobbiesResID = R.string.dog_description_1,
		age = 2
	),

	Dog(
		imageResID = R.drawable.lola,
		nameResID = R.string.dog_name_2,
		hobbiesResID = R.string.dog_description_2,
		age = 16
	),

	Dog(
		imageResID = R.drawable.frankie,
		nameResID = R.string.dog_name_3,
		hobbiesResID = R.string.dog_description_3,
		age = 3
	),

	Dog(
		imageResID = R.drawable.nox,
		nameResID = R.string.dog_name_4,
		hobbiesResID = R.string.dog_description_4,
		age = 8
	),

	Dog(
		imageResID = R.drawable.faye,
		nameResID = R.string.dog_name_5,
		hobbiesResID = R.string.dog_description_5,
		age = 8
	),

	Dog(
		imageResID = R.drawable.bella,
		nameResID = R.string.dog_name_6,
		hobbiesResID = R.string.dog_description_6,
		age = 14
	),

	Dog(
		imageResID = R.drawable.moana,
		nameResID = R.string.dog_name_7,
		hobbiesResID = R.string.dog_description_7,
		age = 2
	),

	Dog(
		imageResID = R.drawable.tzeitel,
		nameResID = R.string.dog_name_8,
		hobbiesResID = R.string.dog_description_8,
		age = 7
	),

	Dog(
		imageResID = R.drawable.leroy,
		nameResID = R.string.dog_name_9,
		hobbiesResID = R.string.dog_description_9,
		age = 4
	),

)