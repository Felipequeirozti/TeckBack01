package br.com.fujideia.iesp.tecback.validation.base;

import java.util.Arrays;
import java.util.List;

public class AtorBase {

    private static final List<String> ATORES = Arrays.asList(
            "Fernanda Montenegro", "Sônia Braga", "Wagner Moura", "Rodrigo Santoro", "Alice Braga",
            "Selton Mello", "Lázaro Ramos", "Camila Pitanga", "Marieta Severo", "Matheus Nachtergaele",
            "Marco Nanini", "Tais Araujo", "Claudia Raia", "Debora Falabella", "Murilo Benício",
            "Giovanna Antonelli", "Juliana Paes", "Regina Duarte", "Tony Ramos", "Jô Soares",
            "Dira Paes", "Patricia Pillar", "Glória Pires", "Paulo José", "Renata Sorrah",
            "Carolina Dieckmann", "Marília Pêra", "Caco Ciocler", "José de Abreu", "Laura Cardoso",
            "Heloísa Périssé", "Bruno Gagliasso", "Claudia Abreu", "Carolina Ferraz", "Nathalia Dill",
            "Giovanna Ewbank", "Nívea Stelmann", "Thiago Lacerda", "Grazi Massafera", "José Wilker",
            "Lima Duarte", "Cassia Kis", "Ana Paula Arósio", "Rodrigo Lombardi", "Vanessa Giácomo",
            "Isis Valverde", "Vladimir Brichta", "Antônio Fagundes", "Leticia Sabatella", "Débora Nascimento"
    );

    public static boolean isAtorValido(String nomeAtor) {
        return ATORES.stream().anyMatch(ator -> ator.equalsIgnoreCase(nomeAtor));
    }
}
