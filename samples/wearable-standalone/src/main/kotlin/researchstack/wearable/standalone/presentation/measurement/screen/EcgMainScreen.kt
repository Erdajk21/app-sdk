package researchstack.wearable.standalone.presentation.measurement.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import researchstack.wearable.standalone.R
import researchstack.wearable.standalone.presentation.component.MainScreenComponent
import researchstack.wearable.standalone.presentation.main.screen.HomeScreenItem
import researchstack.wearable.standalone.presentation.main.screen.getItemIcon
import researchstack.wearable.standalone.presentation.main.screen.getItemTitle
import researchstack.wearable.standalone.presentation.measurement.Route
import researchstack.wearable.standalone.presentation.measurement.viewmodel.EcgMainViewModel

@Composable
fun EcgMainScreen(
    navController: NavHostController,
    ecgMainViewModel: EcgMainViewModel = hiltViewModel()
) {
    val lastMeasurementTime = ecgMainViewModel.lastMeasurementTime.observeAsState().value
    MainScreenComponent(
        title = HomeScreenItem.ECG.getItemTitle(),
        icon = HomeScreenItem.ECG.getItemIcon(),
        content = R.string.ecg_message,
        lastMeasurementTime = lastMeasurementTime,
        onClickMeasure = { navController.navigate(Route.Guide.name) },
    )
}