package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.math.roundToInt

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
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val iConversionFactor = remember { mutableStateOf(1.00) }
    val oConversionFactor = remember { mutableStateOf(1.00) }

    fun convertUnits()
    {
        // ?: - elvis operator, if null to thing after :
        val inPutValueDouble = inputValue.toDoubleOrNull()?:0.0;
        val result = (inPutValueDouble * iConversionFactor.value*100.0/oConversionFactor.value).roundToInt()/100.0;
        outputValue = result.toString();
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // UI elements will be stacked below each other
        Text("Unit Converter",style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue,
            onValueChange = {
                inputValue=it
                convertUnits()
                },
            label = { Text("Enter Value")});
        Spacer(modifier = Modifier.height(16.dp)) // padding is for single element for more precise control
        Row {
            // dropdown needs the same context as a button

            // input box
            Box {
                // Input button
                Button(onClick = { iExpanded=!iExpanded}) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded=false }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            iExpanded=false;
                            inputUnit= "Centimeters";
                            iConversionFactor.value=0.01
                            convertUnits();
                        })
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            iExpanded=false;
                            inputUnit= "Meters";
                            iConversionFactor.value=1.0;
                            convertUnits();
                        })
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            iExpanded=false;
                            inputUnit= "Feet";
                            iConversionFactor.value=0.3048
                            convertUnits();
                        })

                    DropdownMenuItem(
                        text = { Text("Millimeters") },
                        onClick = {
                            iExpanded=false;
                            inputUnit= "Millimeters";
                            iConversionFactor.value=0.001
                            convertUnits();
                        })
                }
            }
            Spacer(modifier = Modifier.width(16.dp));
            // Output box
            Box {
                // Output button
                Button(onClick = { oExpanded=!oExpanded}) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded=false }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            oExpanded=false;
                            outputUnit= "Centimeters";
                            oConversionFactor.value=0.01
                            convertUnits();
                        })
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            oExpanded=false;
                            outputUnit= "Meters";
                            oConversionFactor.value=1.0
                            convertUnits();
                        })
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            oExpanded=false;
                            outputUnit= "Feet";
                            oConversionFactor.value=0.3048
                            convertUnits();
                        })

                    DropdownMenuItem(
                        text = { Text("Millimeters") },
                        onClick = {
                            oExpanded=false;
                            outputUnit= "Millimeters";
                            oConversionFactor.value=0.001
                            convertUnits();
                        })
                }
            }
            // UI elements will be stacked next to each other

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Result: $outputValue $outputUnit",
            style = MaterialTheme.typography.headlineMedium
            )
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