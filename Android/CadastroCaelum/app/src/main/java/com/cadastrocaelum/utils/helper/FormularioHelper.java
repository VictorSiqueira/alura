package com.cadastrocaelum.utils.helper;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.cadastrocaelum.FormularioActivity;
import com.cadastrocaelum.R;
import com.cadastrocaelum.utils.pojo.Aluno;

/**
 * Created by Victor on 23/04/2016.
 */
public class FormularioHelper {

    private EditText edtNome;
    private EditText edtSite;
    private EditText edtEndereco;
    private EditText edtTelefone;
    private Button btnSalvar;
    private RatingBar ratNota;

    public FormularioHelper(FormularioActivity activity) {
        getElementsOfActivity(activity);
    }

    /**
     * metodo para pegar todos os elementos da tela e seta-los nas
     * variaveis corretamente
     */
    private void getElementsOfActivity(Activity activity) {
        edtNome = (EditText)activity.findViewById(R.id.edtNome);
        edtSite = (EditText)activity.findViewById(R.id.edtNome);
        edtEndereco = (EditText)activity.findViewById(R.id.edtNome);
        edtTelefone = (EditText)activity.findViewById(R.id.edtNome);
        btnSalvar = (Button) activity.findViewById(R.id.btnSalvar);
        ratNota = (RatingBar) activity.findViewById(R.id.nota);
    }

    /**
     * Metodo que recupera os dados da activity e monta um Aluno para
     * ser tratado pelo DAO
     * @return
     */
    public Aluno getAlunoFromFormularioActivity(){
        String nome = edtNome.getText().toString();
        String site = edtSite.getText().toString();
        String endereco = edtEndereco.getText().toString();
        String telefone = edtTelefone.getText().toString();
        Float nota = ratNota.getRating();
        return new Aluno(nome, site, endereco,telefone, nota);
    }

    /**
     * metodo para setar nos campos do formulario os dados de
     * um usuario passado no paramento, verficado se cada item ta nulo
     * @param aluno
     */
    public void setAluno2UpdateOnFormulario(Aluno aluno) {
        if(aluno.getNome() != null) edtNome.setText(aluno.getNome());
        if(aluno.getSite() != null)edtSite.setText(aluno.getSite());
        if(aluno.getEndereco() != null)edtEndereco.setText(aluno.getEndereco());
        if(aluno.getTelefone() != null)edtTelefone.setText(aluno.getTelefone());
        if(aluno.getNota() != null)ratNota.setRating(aluno.getNota());
    }
}
