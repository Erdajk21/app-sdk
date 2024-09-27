package researchstack.wearable.standalone.presentation.measurement.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import researchstack.wearable.standalone.R
import researchstack.wearable.standalone.presentation.component.MainScreenComponent
import researchstack.wearable.standalone.presentation.main.screen.HomeScreenItem
import researchstack.wearable.standalone.presentation.main.screen.getItemIcon
import researchstack.wearable.standalone.presentation.main.screen.getItemTitle
import researchstack.wearable.standalone.presentation.measurement.Route
import researchstack.wearable.standalone.presentation.measurement.viewmodel.PpgMainViewModel

@Composable
fun PpgMainScreen(
    navController: NavHostController,
    ppgType: String,
    ppgMainViewModel: PpgMainViewModel = hiltViewModel()
) {
    LaunchedEffect(null) {
        ppgMainViewModel.getLastTimeMeasure(ppgType)
    }
    val lastMeasurementTime = ppgMainViewModel.lastMeasurementTime.observeAsState().value
    MainScreenComponent(
        title = HomeScreenItem.valueOf(ppgType).getItemTitle(),
        icon = HomeScreenItem.valueOf(ppgType).getItemIcon(),
        content = R.string.ppg_message,
        lastMeasurementTime = lastMeasurementTime,
        onClickMeasure = { navController.navigate(Route.Guide.name) },
    )
}
