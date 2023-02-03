package dev.xero.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.xero.woof.data.Dog
import dev.xero.woof.data.dogs
import dev.xero.woof.ui.theme.WoofTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			WoofTheme {
				WoofApp()
			}
		}
	}
}

/**
 * Composable that displays the app bar and list
 * */
@Composable
fun WoofApp() {
	LazyColumn(
		modifier = Modifier
			.background(MaterialTheme.colors.background)
			.fillMaxHeight()
	) {
		items(dogs) {
			dog -> DogItem(dog = dog)
		}
	}
}

/**
 * Composable to display each individual dog item
 * @param dog [Dog] The Dog class containing information about that dog
 * @param modifier [Modifier] Modifiers for this composable
 * */
@Composable
fun DogItem(
	dog: Dog,
	modifier: Modifier = Modifier
) {
	Card(
		modifier = modifier.padding(8.dp),
		elevation = 4.dp
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(8.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			DogIcon(dogIconRes = dog.imageResID)
			DogInformation(dogNameRes = dog.nameResID, dogAge = dog.age)
		}
	}
}

/**
 *  Composable that displays a photo of a dog
 *  @param dogIconRes [DrawableRes] Drawable Res id for the dog icon
 *  @param modifier [Modifier] Modifiers for this composable
 *  */
@Composable
fun DogIcon(
	@DrawableRes dogIconRes: Int,
	modifier: Modifier = Modifier
) {
	Image(
		modifier = modifier
			.size(64.dp)
			.padding(8.dp)
			.clip(RoundedCornerShape(50)),
		painter = painterResource(id = dogIconRes),
		contentDescription = null,
		contentScale = ContentScale.Crop
	)
}

/**
 * Composable that displays a dog's name and age
 * @param dogNameRes [StringRes] String res id for the dog's name
 * @param dogAge [Int] Integer value representing the dog's age
 * @param modifier [Modifier] Modifiers for this composable
 * */
@Composable
fun DogInformation(
	@StringRes dogNameRes: Int,
	dogAge: Int,
	modifier: Modifier = Modifier
) {
	Column {
		Text(
			text = stringResource(id = dogNameRes),
			modifier = modifier.padding(top = 8.dp),
			style = MaterialTheme.typography.h2
		)

		Text(
			text = stringResource(id = R.string.years_old, dogAge),
			style = MaterialTheme.typography.body1
		)
	}
}

/**
 * Preview Composable [Light Theme]
 * */
@Preview
@Composable
fun WoofPreview() {
	WoofTheme(darkTheme = false) {
		WoofApp()
	}
}

/**
 * Preview Composable [Dark Theme]
 * */
@Preview
@Composable
fun WoofDarkPreview() {
	WoofTheme(darkTheme = true) {
		WoofApp()
	}
}