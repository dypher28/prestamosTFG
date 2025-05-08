package org.dam23.prestamostfg.services;

import org.dam23.prestamostfg.infos.AsignaturaInfo;
import org.dam23.prestamostfg.infos.CursoInfo;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.repositories.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

}
