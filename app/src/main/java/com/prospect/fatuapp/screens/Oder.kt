package com.prospect.fatuapp.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.text.style.TextAlign.Companion.End
import androidx.compose.ui.text.style.TextAlign.Companion.Start
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.prospect.fatuapp.components.MyButton
import com.prospect.fatuapp.components.MyInputText
import com.prospect.fatuapp.data.OrderDate
import com.prospect.fatuapp.models.Oder_Product
import com.prospect.fatuapp.utils.formatDate
import com.prospect.fatuapp.viewModels.oderViewModel
import dagger.hilt.android.lifecycle.HiltViewModel


@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalComposeUiApi
@Composable

fun Oder(
    navController: NavController
) {
    val viewmodel = hiltViewModel<oderViewModel>()
    val state=viewmodel.noteList.collectAsState()

    var code by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    var marque by remember {
        mutableStateOf("")
    }
    var prix_vente by remember {
        mutableStateOf("")
    }
    var prix_achat by remember {
        mutableStateOf("")
    }
    var Q by  remember {
        mutableStateOf("")
    }

    var prix_achat_T =0
    var prix_vente_T=0
    var benefice=0
    val context = LocalContext.current

     Column(modifier = Modifier.padding(9.dp))
             {
        TopAppBar(title = {
            Text(text = "App",
            color= Color.White,
                fontWeight = FontWeight.Bold
            )
        },
            actions = {
                Icon(imageVector = Icons.Rounded.Check,
                    contentDescription = "Icon",
                    modifier=Modifier.padding(5.dp),
                    tint = Color.White)
            },
            backgroundColor = Color(0xFFDEB6AB)
        )

        // Content
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ){
                MyInputText(
                    modifier = Modifier
                        .width(100.dp)
                        .align(Alignment.TopStart),
                    text = code,
                    label = "code",
                    onTextChange = {
                        if (it.all { char ->
                                char.isLetterOrDigit() || char.isWhitespace()
                            }) code = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                MyInputText(
                    modifier = Modifier
                        .width(100.dp)
                        .align(Alignment.TopCenter),
                    text = name,
                    label = "name",
                    onTextChange = {
                        if (it.all { char ->
                                char.isLetterOrDigit() || char.isWhitespace()
                            }) name = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)

                )
                MyInputText(
                    modifier = Modifier
                        .width(100.dp)
                        .align(Alignment.TopEnd),
                    text = marque,
                    label = "marque",
                    onTextChange = {
                        if (it.all { char ->
                                char.isLetterOrDigit() || char.isWhitespace()
                            }) marque = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                MyInputText(
                    modifier = Modifier
                        .width(100.dp)
                        .align(Alignment.Center),
                    text = prix_vente,
                    label = "P.V",
                    onTextChange = {
                        if (it.all { char ->
                                char.isDigit() || char.isWhitespace()
                            }) prix_vente = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                MyInputText(
                    modifier = Modifier
                        .width(100.dp)
                        .align(Alignment.CenterStart),
                    text = prix_achat,
                    label = "P.A",
                    onTextChange = {
                        if (it.all { char ->
                                char.isDigit() || char.isWhitespace()
                            }) prix_achat = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                MyInputText(
                    modifier = Modifier
                        .width(100.dp)
                        .align(Alignment.CenterEnd),
                    text = Q,
                    label = "Quatite",
                    onTextChange = {
                        if (it.all { char ->
                                char.isDigit() || char.isWhitespace()
                            })
                            Q = it

                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                if (prix_achat.isNotEmpty() && Q.isNotEmpty()){
                    val p = Integer.parseInt(prix_achat)
                    val q = Integer.parseInt(Q)
                     prix_achat_T = p * q
                }
                if (prix_vente.isNotEmpty() && Q.isNotEmpty()){
                    val p = Integer.parseInt(prix_vente)
                    val q = Integer.parseInt(Q)
                     prix_vente_T = p * q
                }
                if (prix_achat_T != 0 && prix_vente_T!=0){
                    val p = prix_vente_T
                    val q = prix_achat_T
                     benefice = p - q
                }
           /*       Text(text = "PVT: $prix_vente_T FBU", modifier=Modifier.padding(10.dp), textAlign = Start)
                Text(text = "PAT: $prix_achat_T FBU", modifier=Modifier.padding(10.dp), textAlign = Center)
                Text(text = "benefice: $benefice FBU", modifier=Modifier.padding(10.dp), textAlign = End)
            */
            }

                 Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                MyButton(modifier= Modifier
                    .width(100.dp)
                    .height(70.dp),
                    text = "Save",
                    onClick = {
                        if (name.isNotEmpty() && marque.isNotEmpty() &&
                            prix_vente.isNotEmpty() && prix_achat.isNotEmpty() &&
                            Q.isNotEmpty()) {

                            viewmodel.addNote(
                                Oder_Product(
                                    code = code,
                                    name = name,
                                    marque = marque,
                                    prix_achat = prix_achat,
                                    prix_vente = prix_vente,
                                    prix_achat_T = prix_achat_T,
                                    prix_vente_T =prix_vente_T,
                                    benefice = benefice,
                                    Q =Q)
                            )

                            code=""
                            name = ""
                            marque = ""
                            prix_achat=""
                            prix_vente = ""
                            Q=""


                            Toast.makeText(context, "Oder_Product Added",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
                )
            }

        Divider(modifier = Modifier.padding(10.dp))
        LazyColumn{
            items(state.value){ Oder_Product ->
                Oder_ProductRow(Oder_Product = Oder_Product,
                    onOder_ProductClicked = {
                        viewmodel.removeNote(it)
                    })
            }
        }
    }
}



@Composable
fun Oder_ProductRow(
    modifier: Modifier = Modifier,
    Oder_Product: Oder_Product,
    onOder_ProductClicked: (Oder_Product) -> Unit) {
    Surface(
        modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(0xFFECCCB2),
        elevation = 1.dp) {
        Column(modifier
            .clickable { onOder_ProductClicked(Oder_Product) }
            .padding(horizontal = 14.dp, vertical = 1.dp),
            horizontalAlignment = Alignment.Start) {

                Column {
                    Spacer(modifier = Modifier.padding(3.dp))
                    Row {
                        Box(modifier= Modifier
                            .fillMaxWidth()
                            .height(40.dp)) {
                            Text("Code",
                                modifier=Modifier.align(alignment = Alignment.TopStart),
                                color=Color(0xffAC7088),
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.ExtraBold
                            )
                            Text(text = "Name",
                                modifier=Modifier.align(alignment = Alignment.TopCenter),
                                color=Color(0xffAC7088),
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.ExtraBold

                            )
                            Text(text = "Marque",
                                modifier=Modifier.align(alignment = Alignment.TopEnd),
                                color=Color(0xffAC7088),
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.ExtraBold
                            )
                            Text(text = Oder_Product.code,
                                modifier=Modifier.align(alignment = Alignment.BottomStart),
                                color=Color.White,
                                style = MaterialTheme.typography.subtitle2,
                            )
                            Text(text = Oder_Product.name,
                                modifier=Modifier.align(alignment = Alignment.BottomCenter),
                                color=Color.White,
                                style = MaterialTheme.typography.subtitle2,
                            )
                            Text(text = Oder_Product.marque,
                                modifier=Modifier.align(alignment = Alignment.BottomEnd),
                                color=Color.White,
                                style = MaterialTheme.typography.subtitle2,
                                textAlign = End
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(7.dp))

                    Row() {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)) {
                            Text(
                                "PA",
                                modifier = Modifier.align(alignment = Alignment.TopStart),
                                color=Color(0xffAC7088),
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.ExtraBold
                            )
                            Text(
                                text = "PV",
                                modifier = Modifier.align(alignment = Alignment.TopCenter),
                                color=Color(0xffAC7088),
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.ExtraBold
                            )
                            Text(
                                text = "PAT",
                                modifier = Modifier.align(alignment = Alignment.TopEnd),
                                color=Color(0xffAC7088),
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.ExtraBold

                                )
                            Text(
                                text = Oder_Product.prix_achat,
                                modifier = Modifier.align(alignment = Alignment.BottomStart),
                                color = Color.White,
                                style = MaterialTheme.typography.subtitle2,
                            )
                            Text(
                                text = Oder_Product.prix_vente,
                                modifier = Modifier.align(alignment = Alignment.BottomCenter),
                                color = Color.White,
                                style = MaterialTheme.typography.subtitle2,
                            )
                            Text(
                                text = Oder_Product.prix_achat_T.toString(),
                                modifier = Modifier.align(alignment = Alignment.BottomEnd),
                                color = Color.White,
                                style = MaterialTheme.typography.subtitle2,
                                textAlign = End
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(7.dp))

                    Row() {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)) {
                            Text(
                                "PVT",
                                modifier = Modifier.align(alignment = Alignment.TopStart),
                                color=Color(0xffAC7088),
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.ExtraBold

                            )
                            Text(
                                text = "Benefice",
                                modifier = Modifier.align(alignment = Alignment.TopCenter),
                                color=Color(0xffAC7088),
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.ExtraBold
                            )
                            Text(
                                text = "Quantity",
                                modifier = Modifier.align(alignment = Alignment.TopEnd),
                                color=Color(0xffAC7088),
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.ExtraBold
                                )
                            Text(
                                text = Oder_Product.prix_vente_T.toString(),
                                modifier = Modifier.align(alignment = Alignment.BottomStart),
                                color = Color.Black,
                                style = MaterialTheme.typography.subtitle2,
                            )
                            Text(
                                text = Oder_Product.benefice.toString(),
                                modifier = Modifier.align(alignment = Alignment.BottomCenter),

                                color = Color.Black,
                                style = MaterialTheme.typography.subtitle2,
                            )
                            Text(
                                text = Oder_Product.Q,
                                modifier = Modifier.align(alignment = Alignment.BottomEnd),
                                color = Color.Black,
                                style = MaterialTheme.typography.subtitle2,
                                textAlign = End
                            )
                        }
                        }

                    Spacer(modifier = Modifier.padding(5.dp))
                    Column(modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = formatDate(Oder_Product.entryDate.time),
                            color=Color.White,
                            style = MaterialTheme.typography.caption,
                            fontWeight = FontWeight.Bold
                                   )
                    }
                    }

            }
        }
    }

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun Oder_ProductsScreenPreview() {
    val context= LocalContext.current

    Oder(
    navController = NavController(context)
    )
}