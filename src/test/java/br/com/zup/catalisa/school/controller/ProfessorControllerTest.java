package br.com.zup.catalisa.school.controller;

import br.com.zup.catalisa.school.business.domain.dto.ProfessorDTO;
import br.com.zup.catalisa.school.business.service.ProfessorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ProfessorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProfessorService professorService;

    @InjectMocks
    private ProfessorController professorController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(professorController).build();
    }


    @Test
    public void testCriarProfessor() throws Exception {
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setNome("Wellington");


    }

}
