package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter();
                }
            }
        }
    }
}
@Composable
fun UnitConverter() {
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(0.01f) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // UI elements will be stacked below each other
        Text("Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue,
            onValueChange = {inputValue=it},
            label = { Text(text = "Enter Value")});
        Spacer(modifier = Modifier.height(16.dp)) // padding is for single element for more precise control
        Row {
            // dropdown needs the same context as a button
            Box {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = { /*TODO*/ })

                    DropdownMenuItem(
                        text = { Text("Millimeters") },
                        onClick = { /*TODO*/ })
                }
            }
            Spacer(modifier = Modifier.width(16.dp));
            Box {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = { /*TODO*/ })

                    DropdownMenuItem(
                        text = { Text("Millimeters") },
                        onClick = { /*TODO*/ })
                }
            }
            // UI elements will be stacked next to each other

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result: ")
    }
}

@Preview(showBackground = true) // allows of checking how it looks after clicking split, without launching emulator
@Composable
fun UnitConverterPreview() {
        UnitConverter();
        //Greeting("Android")

}


//@Composable
//fun UnitConverter()
//{
//    Column{
//        // UI elements will be stacked below each other
//        Text("Unit Converter")
//        OutlinedTextField(value = "Enter", onValueChange = {})
//        Row {
//            val context:Context = LocalContext.current;
//            // UI elements will be stacked next to each other
//            Button(onClick = { Toast.makeText(context,"Thanks for click",Toast.LENGTH_LONG).show()}) {
//                Text(text = "Click Me!!!!")
//            }
//        }
//    }
//}