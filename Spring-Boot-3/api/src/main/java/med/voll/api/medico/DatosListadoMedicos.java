package med.voll.api.medico;

public record DatosListadoMedicos (Long id, String nombre, String especialidad, String documento, String email){
    public DatosListadoMedicos (Medico medico){
        this(medico.getId(), medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }
}
