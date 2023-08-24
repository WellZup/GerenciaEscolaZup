package br.com.zup.catalisa.school.controller;

import br.com.zup.catalisa.school.business.domain.dto.AlunoDTO;
import br.com.zup.catalisa.school.business.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AlunoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AlunoService alunoService;

    @InjectMocks
    private AlunoController alunoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(alunoController).build();
    }

    @Test
    public void testCriarAluno() throws Exception {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Wellington");

        when(alunoService.criar(any(AlunoDTO.class))).thenReturn(alunoDTO);

        mockMvc.perform(get("/v1/aluno/criar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\": \"Wellington\"}"))
                        .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$.nome").value("Wellington"));

        verify(alunoService, times(1)).criar(any(AlunoDTO.class));
    }

    @Test
    public void testBuscarAlunoId() throws Exception {

        AlunoDTO aluno1 = new AlunoDTO(1L,"Wellington", 41, "well@zup.exemplo");
        AlunoDTO aluno2 = new AlunoDTO(2L,"Well", 42, "well@zup.exemplo.com");


        when(alunoService.buscarPorId(1L)).thenReturn(aluno1);
        when(alunoService.buscarPorId(2L)).thenReturn(aluno2);

        mockMvc.perform(get("/v1/aluno/buscarid/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));

        verify(alunoService, times(1)).buscarPorId(1L);

        mockMvc.perform(get("/v1/aluno/buscarid/2"))
                .andExpect(status().isOk())
                .andExpect(content()
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(2));

        verify(alunoService, times(1)).buscarPorId(2L);


    }

//    @Test
//    public void testAtualizar() throws Exception {
//
//        AlunoDTO aluno1 = new AlunoDTO(1L, "Wellington", 41, "well@zup.com");
//        when(alunoService.atualizar(anyLong(), any(AlunoDTO.class))).thenReturn(new AlunoDTO());
//
//        mockMvc.perform(put("/v1/alunos/atualizar/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"id\": 1L, \"nome\": \"Well\", \"idade\": 42, \"email\": \"well@zup.com.br\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L))
//                .andExpect(jsonPath("$.nome").value("Well"))
//                .andExpect(jsonPath("$.idade").value(42))
//                .andExpect(jsonPath("$.email").value("well@zup.com.br"));
//        verify(alunoService, times(1)).atualizar(anyLong(), any(AlunoDTO.class));
//    }

    @Test
    public void testDeletar () throws Exception {
        when(alunoService.deletar(anyLong())).thenReturn(true);

        mockMvc.perform(delete("/v1/aluno/deletar/1"))
                .andExpect(status().isNoContent());
        verify(alunoService, times(1)).deletar(anyLong());
    }

}

