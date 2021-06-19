package cz.levinzonr.compose.template.presentation.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import cz.levinzonr.compose.template.presentation.components.Placeholder
import cz.levinzonr.router.core.Route
import cz.levinzonr.router.core.RouteArg
import cz.levinzonr.router.core.RouteArgType

@Route(name = "details", args = [RouteArg("id", type = RouteArgType.StringType)])
@Composable
fun DetailsScreen(viewModel: DetailsViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState()
    Placeholder(title = state.value)
}
