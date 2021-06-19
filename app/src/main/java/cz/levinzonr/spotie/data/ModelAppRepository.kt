package cz.levinzonr.spotie.data

import cz.levinzonr.spotie.data.network.Api
import cz.levinzonr.spotie.domain.repositories.ModelRepository
import javax.inject.Inject

class ModelAppRepository @Inject constructor(
    private val api: Api
) : ModelRepository
