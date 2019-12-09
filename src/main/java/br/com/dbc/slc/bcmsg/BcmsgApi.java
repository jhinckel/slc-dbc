package br.com.dbc.slc.bcmsg;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbc.slc.model.BcMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "BCMSG Data")
@RestController
@RequestMapping("/slc/v1")
public interface BcmsgApi {

    @GetMapping(value = "/bcmsg/id/{bcmsgId}")
    @ApiOperation(value="Return BCMSG from BCMSG ID", notes="BCMSG data API", response = BcMsg.class)
    @ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
    ResponseEntity<BcMsg> getBcmsgById(@PathVariable(value = "bcmsgId") Long bcmsgId) throws BcmsgNotFoundException;

	@GetMapping(value = "/bcmsg/operation/{operationNumber}")
	@ApiOperation(value="Return BCMSG from BCMSG operationNumber", notes="BCMSG data API", response = BcMsg.class)
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
	ResponseEntity<List<BcMsg>> getBcmsgByOperationNumber(@PathVariable(value = "operationNumber") String operationNumber) throws BcmsgNotFoundException;

}
