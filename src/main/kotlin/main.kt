import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        SimpleDropdown()
    }
}

@Composable
fun SimpleDropdown() {
    val options = listOf("Q", "W", "E", "R", "T", "Y")
    var selected by remember { mutableStateOf(0) }
    var expanded by remember { mutableStateOf(false) }

    Box {
        IconButton(onClick = { expanded = true }) {
            Row {
                Text(options[selected])
                Spacer(Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "Show dropdown content"
                )
            }
        }
        DropdownMenu(expanded, { expanded = false }) {
            options.forEachIndexed { idx, item ->
                DropdownMenuItem(onClick = { selected = idx; expanded = false }) {
                    Text(item)
                }
            }
        }
    }
}
