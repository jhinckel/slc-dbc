package slc.br.com.dbc.slc.bcmsg;

import static org.mockito.BDDMockito.given;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.dbc.slc.bcmsg.BcmsgController;
import br.com.dbc.slc.bcmsg.BcmsgNotFoundException;
import br.com.dbc.slc.bcmsg.BcmsgRepository;
import br.com.dbc.slc.model.BcMsg;

@RunWith(MockitoJUnitRunner.class)
public class BcmsgControllerTest {

    @InjectMocks
    private BcmsgController bcmsgController;

    @Mock
    private BcmsgRepository bcmsgRepository;

    @Test
    public void testBcmsgById() throws Throwable {
        BcMsg bcmsg = getBcmsgObjectFilter(1L);

        given(bcmsgRepository.load(bcmsg)).willReturn(getBcmsgObjectFilter(1L));

        BcMsg bcmsgFound = bcmsgController.getBcmsgById(bcmsg);

        Assertions.assertThat(bcmsgFound.getDomSist()).isEqualTo(bcmsg.getDomSist());
        Assertions.assertThat(bcmsgFound.getIdentdDestinatario()).isEqualTo(bcmsg.getIdentdDestinatario());
        Assertions.assertThat(bcmsgFound.getIdentdEmissor()).isEqualTo(bcmsg.getIdentdEmissor());
        Assertions.assertThat(bcmsgFound.getnUOp()).isEqualTo(bcmsg.getnUOp());
    }

    @Test(expected = BcmsgNotFoundException.class)
    public void testBcmsgNotFound() throws Throwable {
        BcMsg bcmsg = getBcmsgObjectFilter(1L);

        bcmsgController.getBcmsgById(bcmsg);
    }

    private BcMsg getBcmsgObjectFilter(Long id) {
        BcMsg bcmsg = new BcMsg();

        bcmsg.setId(id);
        bcmsg.setDomSist("12345");
        bcmsg.setIdentdEmissor("234324214");
        bcmsg.setnUOp("43242323");
        bcmsg.setIdentdDestinatario("32423423");

        return bcmsg;
    }

}
