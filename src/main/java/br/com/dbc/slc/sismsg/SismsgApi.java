package br.com.dbc.slc.sismsg;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbc.slc.model.SisMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "SISMSG Data")
@RestController
@RequestMapping("/slc/v1")
public interface SismsgApi {

    @GetMapping(value = "/sismsg/id/{sismsgId}")
    @ApiOperation(value="Return SISMSG from SISMSG ID", notes="SISMSG data API", response = SisMsg.class)
    @ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
    ResponseEntity<SisMsg> getSismsgById(@PathVariable(value = "sismsgId") Long sismsgId) throws SismsgNotFoundException;

}
