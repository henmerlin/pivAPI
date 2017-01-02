/*
 * To change this license header. choose License Headers in Project Properties.
 * To change this template file. choose Toolsd, Templates
 * and open the template in the editor.
 */
package model.business.atingimento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G0042204
 */
public final class AtingimentoPiv {

    public static Double calcularTarget(Double atingimento) {
        for (NotaAtingimento n : carregaNotaAtingimentos()) {
            if (atingimento <= n.getNota()) {
                return n.getAtingimento();
            }
        }
        return 0d;
    }

    public static List<NotaAtingimento> carregaNotaAtingimentos() {

        Double nota = 0d;
        Double atingimento = 0d;

        List<NotaAtingimento> na = new ArrayList<>();

        na.add(new NotaAtingimento(nota, atingimento));

        na.add(new NotaAtingimento(0.8d, 0.075d));
        na.add(new NotaAtingimento(0.81d, 0.078d));
        na.add(new NotaAtingimento(0.82d, 0.08d));
        na.add(new NotaAtingimento(0.83d, 0.083d));
        na.add(new NotaAtingimento(0.84d, 0.085d));
        na.add(new NotaAtingimento(0.85d, 0.088d));
        na.add(new NotaAtingimento(0.86d, 0.09d));
        na.add(new NotaAtingimento(0.87d, 0.093d));
        na.add(new NotaAtingimento(0.88d, 0.095d));
        na.add(new NotaAtingimento(0.89d, 0.098d));
        na.add(new NotaAtingimento(0.9d, 0.1d));
        na.add(new NotaAtingimento(0.91d, 0.15d));
        na.add(new NotaAtingimento(0.92d, 0.153d));
        na.add(new NotaAtingimento(0.93d, 0.155d));
        na.add(new NotaAtingimento(0.94d, 0.158d));
        na.add(new NotaAtingimento(0.95d, 0.16d));
        na.add(new NotaAtingimento(0.96d, 0.163d));
        na.add(new NotaAtingimento(0.97d, 0.165d));
        na.add(new NotaAtingimento(0.98d, 0.168d));
        na.add(new NotaAtingimento(0.99d, 0.17d));
        na.add(new NotaAtingimento(1d, 0.25d));
        na.add(new NotaAtingimento(1.01d, 0.254d));
        na.add(new NotaAtingimento(1.02d, 0.257d));
        na.add(new NotaAtingimento(1.03d, 0.261d));
        na.add(new NotaAtingimento(1.04d, 0.264d));
        na.add(new NotaAtingimento(1.05d, 0.268d));
        na.add(new NotaAtingimento(1.06d, 0.271d));
        na.add(new NotaAtingimento(1.07d, 0.275d));
        na.add(new NotaAtingimento(1.08d, 0.278d));
        na.add(new NotaAtingimento(1.09d, 0.282d));
        na.add(new NotaAtingimento(1.1d, 0.285d));
        na.add(new NotaAtingimento(1.11d, 0.289d));
        na.add(new NotaAtingimento(1.12d, 0.292d));
        na.add(new NotaAtingimento(1.13d, 0.296d));
        na.add(new NotaAtingimento(1.14d, 0.299d));
        na.add(new NotaAtingimento(1.15d, 0.303d));
        na.add(new NotaAtingimento(1.16d, 0.306d));
        na.add(new NotaAtingimento(1.17d, 0.31d));
        na.add(new NotaAtingimento(1.18d, 0.313d));
        na.add(new NotaAtingimento(1.19d, 0.317d));
        na.add(new NotaAtingimento(1.2d, 0.32d));
        na.add(new NotaAtingimento(1.21d, 0.325d));
        na.add(new NotaAtingimento(1.22d, 0.33d));
        na.add(new NotaAtingimento(1.23d, 0.335d));
        na.add(new NotaAtingimento(1.24d, 0.34d));
        na.add(new NotaAtingimento(1.25d, 0.345d));
        na.add(new NotaAtingimento(1.26d, 0.35d));
        na.add(new NotaAtingimento(1.27d, 0.355d));
        na.add(new NotaAtingimento(1.28d, 0.36d));
        na.add(new NotaAtingimento(1.29d, 0.365d));
        na.add(new NotaAtingimento(1.3d, 0.37d));
        na.add(new NotaAtingimento(1.31d, 0.375d));
        na.add(new NotaAtingimento(1.32d, 0.38d));
        na.add(new NotaAtingimento(1.33d, 0.385d));
        na.add(new NotaAtingimento(1.34d, 0.39d));
        na.add(new NotaAtingimento(1.35d, 0.395d));
        na.add(new NotaAtingimento(1.36d, 0.4d));
        na.add(new NotaAtingimento(1.37d, 0.405d));
        na.add(new NotaAtingimento(1.38d, 0.41d));
        na.add(new NotaAtingimento(1.39d, 0.415d));
        na.add(new NotaAtingimento(1.4d, 0.42d));
        na.add(new NotaAtingimento(1.41d, 0.428d));
        na.add(new NotaAtingimento(1.42d, 0.436d));
        na.add(new NotaAtingimento(1.43d, 0.444d));
        na.add(new NotaAtingimento(1.44d, 0.452d));
        na.add(new NotaAtingimento(1.45d, 0.46d));
        na.add(new NotaAtingimento(1.46d, 0.468d));
        na.add(new NotaAtingimento(1.47d, 0.476d));
        na.add(new NotaAtingimento(1.48d, 0.484d));
        na.add(new NotaAtingimento(1.49d, 0.489d));
        na.add(new NotaAtingimento(1.5d, 0.493d));
        na.add(new NotaAtingimento(2d, 0.5d));

        return na;
    }

}
