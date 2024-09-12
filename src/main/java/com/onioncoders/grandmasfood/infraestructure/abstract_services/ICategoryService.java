package com.onioncoders.grandmasfood.infraestructure.abstract_services;

import com.onioncoders.grandmasfood.api.models.request.CategoryRequest;
import com.onioncoders.grandmasfood.api.models.responses.CategoryResponse;


public interface ICategoryService extends CrudService<CategoryRequest,CategoryResponse,Long> {

}
