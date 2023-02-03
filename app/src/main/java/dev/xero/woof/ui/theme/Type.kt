package dev.xero.woof.ui.theme

import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.xero.woof.R

val Inter = FontFamily(
	Font(R.font.inter_regular),
	Font(R.font.inter_bold, FontWeight.Bold)
)

val Outfit = FontFamily(
	Font(R.font.outfit_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
	h1 = TextStyle(
		fontFamily = Outfit,
		fontWeight = FontWeight.Normal,
		fontSize = 30.sp
	),

	h2 = TextStyle(
		fontFamily = Inter,
		fontWeight = FontWeight.Bold,
		fontSize = 20.sp
	),

	h3 = TextStyle(
		fontFamily = Inter,
		fontWeight = FontWeight.Bold,
		fontSize = 14.sp
	),

	body1 = TextStyle(
		fontFamily = Inter,
		fontWeight = FontWeight.Normal,
		fontSize = 14.sp
	)
)