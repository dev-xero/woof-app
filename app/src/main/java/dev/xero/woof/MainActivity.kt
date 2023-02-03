package dev.xero.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
	Scaffold(
		topBar = { WoofTopAppBar() }
	) {
		padding ->
		LazyColumn(
			modifier = Modifier
				.background(MaterialTheme.colors.background)
				.fillMaxHeight()
				.padding(padding)
		) {
			items(dogs) { dog ->
				DogItem(dog = dog)
			}
		}
	}
}

/**
 * Composable for the top app bar
 * @param modifier [Modifier] Modifiers for this composable
 * */
@Composable
fun WoofTopAppBar(
	modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier
			.fillMaxWidth()
			.background(color = MaterialTheme.colors.primary),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.spacedBy(4.dp)
	) {
		Image(
			painter = painterResource(id = R.drawable.ic_woof_logo),
			contentDescription = null,
			modifier = modifier
				.padding(16.dp)
				.size(48.dp)
		)
		
		Text(
			text = stringResource(id = R.string.app_name),
			style = MaterialTheme.typography.h1
		)
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
	var expanded by remember { mutableStateOf(false) }

	Card(
		modifier = modifier.padding(8.dp),
		elevation = 4.dp
	) {
		Column(
			modifier = modifier
				.animateContentSize(
					animationSpec = spring(
						dampingRatio = Spring.DampingRatioMediumBouncy,
						stiffness = Spring.StiffnessLow
					)
				)
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(8.dp),
				verticalAlignment = Alignment.CenterVertically
			) {
				DogIcon(dogIconRes = dog.imageResID)
				DogInformation(dogNameRes = dog.nameResID, dogAge = dog.age)
				Spacer(modifier = Modifier.weight(1f))
				DogItemButton(expanded = expanded, onClick = { expanded = !expanded })
			}
			
			if (expanded) {
				DogHobby(dogHobby = dog.hobbiesResID)
			}
		}
	}
}

/**
 * Composable defining the item dropdown button
 * @param expanded [Boolean] Whether the item is expanded or not
 * @param onClick [Function] When the button is clicked
 * @param modifier [Modifier] Modifier for this composable
 * */
@Composable
private fun DogItemButton(
	expanded: Boolean,
	onClick: () -> Unit,
	modifier: Modifier = Modifier
) {
	val icon = if (!expanded) Icons.Filled.ExpandMore else Icons.Filled.ExpandLess
	IconButton(onClick = onClick) {
		Icon(
			imageVector = icon,
			contentDescription = stringResource(id = R.string.expand_button_content_description)
		)
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
 * Composable that displays the dog's hobbies
 * @param dogHobby [StringRes] String Res ID for the dog's hobby
 * @param modifier [Modifier] Modifier for this composable
 * */
@Composable
fun DogHobby(
	@StringRes dogHobby: Int,
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
			.padding(
				top = 8.dp,
				start = 16.dp,
				bottom = 16.dp,
				end = 16.dp
			)
	) {
		Text(
			text = stringResource(id = R.string.about),
			style = MaterialTheme.typography.h3
		)
		Text(
			text = stringResource(id = dogHobby),
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