package br.com.dbc.slc.doc;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbc.slc.model.DOC;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "Document Data")
@RestController
@RequestMapping("/doc/v1")
public interface DocApi {

    @GetMapping(value = "/doc/id/{docId}")
    @ApiOperation(value="Return DOC from DOC ID", notes="DOC data API", response = DOC.class)
    @ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
    ResponseEntity<DOC> getDocById(@PathVariable(value = "docId") Long docId) throws DocNotFoundException;

}
