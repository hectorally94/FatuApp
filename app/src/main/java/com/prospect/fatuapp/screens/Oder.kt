package com.prospect.fatuapp.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prospect.fatuapp.components.MyButton
import com.prospect.fatuapp.components.MyInputText
import com.prospect.fatuapp.data.OrderDate
import com.prospect.fatuapp.models.Oder_Product
import com.prospect.fatuapp.utils.formatDate


@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalComposeUiApi
@Composable
fun Oder(
    Oder_Products: List<Oder_Product>,
    onAddOder_Product: (Oder_Product) -> Unit,
    onRemoveOder_Product: (Oder_Product) -> Unit
) {

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
    var prix_achat_T by remember {
        mutableStateOf("")
    }
    var prix_vente_T by remember {
        mutableStateOf("")
    }
    var benefice by remember {
        mutableStateOf("")
    }
    var Q by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

        Column(modifier = Modifier.padding(1.dp)) {
        TopAppBar(title = {
            Text(text = "FatuApp")
        },
            actions = {
                Icon(imageVector = Icons.Rounded.Check,
                    contentDescription = "Icon")
            },
            backgroundColor = Color(0xFFDADFE3)
        )

        // Content
        Row()
        {
            Row() {
                Column(
                    horizontalAlignment = Alignment.Start,
                )
                {

                    MyInputText(
                        modifier = Modifier.width(100.dp),
                        text = code,
                        label = "code",
                        onTextChange = {
                            if (it.all { char ->
                                    char.isLetter() || char.isWhitespace()
                                }) code = it
                        } )

                    MyInputText(
                        modifier = Modifier.width(100.dp),
                        text = name,
                        label = "name",
                        onTextChange = {
                            if (it.all { char ->
                                    char.isLetter() || char.isWhitespace()
                                }) name = it
                        })
                    MyInputText(
                        modifier = Modifier.width(100.dp),
                        text = marque,
                        label = "marque",
                        onTextChange = {
                            if (it.all { char ->
                                    char.isLetter() || char.isWhitespace()
                                }) marque = it
                        })

                }
            }
            Row() {
                Column()
                {
                    MyInputText(
                        modifier = Modifier.width(100.dp),
                        text = prix_achat,
                        label = "P.A",
                        onTextChange = {
                            if (it.all { char ->
                                    char.isLetter() || char.isWhitespace()
                                }) prix_achat = it
                        })
                    MyInputText(
                        modifier = Modifier.width(100.dp),
                        text = prix_vente,
                        label = "P.V",
                        onTextChange = {
                            if (it.all { char ->
                                    char.isLetter() || char.isWhitespace()
                                }) prix_vente = it
                        })
                    MyInputText(
                        modifier = Modifier.width(100.dp),
                        text = prix_achat_T,
                        label = "P.A.T",
                        onTextChange = {
                            if (it.all { char ->
                                    char.isLetter() || char.isWhitespace()
                                }) prix_achat_T = it
                        })

                }
            }
Row() {
    Column() {
        MyInputText(
            modifier = Modifier.width(100.dp),
            text = prix_vente_T,
            label = "P.V.T",
            onTextChange = {
                if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) prix_vente_T = it
            })

        MyInputText(
            modifier = Modifier.width(100.dp),
            text = benefice,
            label = "Benefice",
            onTextChange = {
                if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) benefice = it
            })
        MyInputText(
            modifier = Modifier.width(100.dp),
            text = Q,
            label = "Q",
            onTextChange = {
                if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) Q = it
            })

    }
}
           MyButton(text = "Save",
                onClick = {
                    if (name.isNotEmpty() && marque.isNotEmpty() &&
                        prix_vente.isNotEmpty() && prix_achat.isNotEmpty() &&
                        prix_achat_T.isNotEmpty() && prix_achat_T.isNotEmpty()&& benefice.isNotEmpty()) {
                        onAddOder_Product(
                            Oder_Product(code = code,
                                name = name,
                                marque = marque,
                                prix_achat = prix_achat,
                                prix_vente= prix_vente,
                                prix_achat_T = prix_achat_T,
                                prix_vente_T=prix_vente_T,
                                benefice = benefice,
                                Q=Q)
                        )
                        code=""
                        name = ""
                        marque = ""
                        prix_achat = ""
                        prix_vente= ""
                        prix_achat_T = ""
                        prix_vente_T=""
                        benefice =""
                        Q=""
                        Toast.makeText(context, "Oder_Product Added",
                            Toast.LENGTH_SHORT).show()
                    }
                })
        }
        Divider(modifier = Modifier.padding(10.dp))
        LazyColumn{
            items(Oder_Products){ Oder_Product ->
                Oder_ProductRow(Oder_Product = Oder_Product,
                    onOder_ProductClicked = { onRemoveOder_Product(it) })
            }
        }

    }
    // Smooth scroll to specified pixels on first composition

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
        color = Color(0xFFDFE6EB),
        elevation = 1.dp) {
        Column(modifier
            .clickable { onOder_ProductClicked(Oder_Product) }
            .padding(horizontal = 14.dp, vertical = 1.dp),
            horizontalAlignment = Alignment.Start) {
            Text(text = Oder_Product.code,
                style = MaterialTheme.typography.subtitle2)
            Text(text = Oder_Product.name, style = MaterialTheme.typography.subtitle1)
            Text(text = Oder_Product.marque,
                style = MaterialTheme.typography.subtitle2)
            Text(text = Oder_Product.prix_achat, style = MaterialTheme.typography.subtitle1)
            Text(text = Oder_Product.prix_vente,
                style = MaterialTheme.typography.subtitle2)
            Text(text = Oder_Product.prix_achat_T, style = MaterialTheme.typography.subtitle1)
            Text(text = Oder_Product.prix_vente_T,
                style = MaterialTheme.typography.subtitle2)
            Text(text = Oder_Product.benefice, style = MaterialTheme.typography.subtitle1)
            Text(text = formatDate(Oder_Product.entryDate.time),
                style = MaterialTheme.typography.caption)

        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun Oder_ProductsScreenPreview() {
    Oder(Oder_Products = OrderDate().loadOders(), onAddOder_Product = {}, onRemoveOder_Product = {})
}