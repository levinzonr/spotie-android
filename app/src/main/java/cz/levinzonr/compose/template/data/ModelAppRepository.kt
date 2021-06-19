package cz.levinzonr.compose.template.data

import cz.levinzonr.compose.template.data.network.Api
import cz.levinzonr.compose.template.domain.repositories.ModelRepository
import javax.inject.Inject

class ModelAppRepository @Inject constructor(
    private val api: Api
) : ModelRepository
