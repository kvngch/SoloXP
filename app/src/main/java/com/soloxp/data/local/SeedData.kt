package com.soloxp.data.local

import com.soloxp.domain.model.*
import java.util.UUID

object SeedData {
    fun getInitialQuests(): List<Quest> {
        val quests = mutableListOf<Quest>()

        // --- HEALTH ---
        quests.addAll(listOf(
            createQuest("Hydratation Vitale", QuestCategory.HEALTH, Difficulty.MICRO, 1, 5, 
                "Bois un grand verre d'eau immédiatement.", 
                "Verre vide."),
            createQuest("Désintox Sucrée", QuestCategory.HEALTH, Difficulty.STANDARD, 0, 20, 
                "Ne consomme aucune boisson sucrée ou soda aujourd'hui.", 
                "Journée terminée sans sucre liquide."),
            createQuest("Apport Vitaminé", QuestCategory.HEALTH, Difficulty.MINI, 2, 10, 
                "Mange un fruit ou un légume cru.", 
                "Portion consommée."),
            createQuest("Lumière Solaire", QuestCategory.HEALTH, Difficulty.MINI, 10, 15, 
                "Expose-toi à la lumière naturelle du jour pendant 10 minutes.", 
                "10 minutes passées dehors ou près d'une fenêtre."),
            createQuest("Coupure Caféine", QuestCategory.HEALTH, Difficulty.STANDARD, 0, 25, 
                "Ne bois pas de café après 14h00.", 
                "Aucune caféine ingérée après l'heure limite.")
        ))

        // --- SPORT ---
        quests.addAll(listOf(
            createQuest("Éveil Musculaire", QuestCategory.SPORT, Difficulty.MICRO, 2, 5, 
                "Fais 5 pompes (sur genoux acceptés) ou 5 squats.", 
                "5 répétitions effectuées."),
            createQuest("Marche de l'Éclaireur", QuestCategory.SPORT, Difficulty.MINI, 15, 20, 
                "Marche d'un pas dynamique pendant 15 minutes.", 
                "15 minutes de marche complétées."),
            createQuest("Gainage du Guerrier", QuestCategory.SPORT, Difficulty.MINI, 1, 15, 
                "Tiens la position de planche (gainage) le plus longtemps possible (min 30s).", 
                "30 secondes de gainage tenues."),
            createQuest("Mobilité Articulaire", QuestCategory.SPORT, Difficulty.MINI, 5, 10, 
                "Fais tourner tes poignets, épaules, nuque et chevilles.", 
                "Toutes les articulations échauffées."),
            createQuest("Assaut Cardio", QuestCategory.SPORT, Difficulty.BOSS, 30, 100, 
                "Une séance de sport intense (course, hiit, salle) de 30 min minimum.", 
                "Séance terminée et transpiration validée.")
        ))

        // --- MIND ---
        quests.addAll(listOf(
            createQuest("Respiration Tactique", QuestCategory.MIND, Difficulty.MICRO, 2, 5, 
                "Respire en carré : inspire 4s, bloque 4s, expire 4s, bloque 4s. Répète 4 fois.", 
                "4 cycles de respiration carrée effectués."),
            createQuest("Lecture Arcane", QuestCategory.MIND, Difficulty.STANDARD, 15, 25, 
                "Lis 10 pages d'un livre (pas de réseaux sociaux).", 
                "10 pages lues."),
            createQuest("Gratitude Quotidienne", QuestCategory.MIND, Difficulty.MINI, 5, 15, 
                "Écris 3 choses positives qui te sont arrivées récemment.", 
                "3 points notés sur papier ou note."),
            createQuest("Silence Force", QuestCategory.MIND, Difficulty.MINI, 5, 10, 
                "Reste assis en silence sans rien faire pendant 5 minutes.", 
                "5 minutes de silence absolu."),
            createQuest("Apprentissage Rapide", QuestCategory.MIND, Difficulty.STANDARD, 15, 20, 
                "Regarde une vidéo éducative ou lis un article sur un sujet nouveau.", 
                "Une nouvelle notion apprise.")
        ))

        // --- DISCIPLINE ---
        quests.addAll(listOf(
            createQuest("Le Lit du Roi", QuestCategory.DISCIPLINE, Difficulty.MICRO, 2, 5, 
                "Fais ton lit au carré dès le lever.", 
                "Lit fait et chambre rangée en apparence."),
            createQuest("Environnement Pur", QuestCategory.DISCIPLINE, Difficulty.MINI, 5, 10, 
                "Débarrasse ton bureau ou ta table de tout ce qui traîne.", 
                "Surface de travail vide et propre."),
            createQuest("La Grenouille", QuestCategory.DISCIPLINE, Difficulty.STANDARD, 0, 30, 
                "Identifie et accomplis ta tâche la plus pénible en premier.", 
                "La tâche la plus redoutée est faite."),
            createQuest("Zéro Distraction", QuestCategory.DISCIPLINE, Difficulty.BOSS, 60, 50, 
                "Travaille 60 minutes sans téléphone ni notifications.", 
                "1 heure de travail ininterrompu."),
            createQuest("Préparation Tactique", QuestCategory.DISCIPLINE, Difficulty.MINI, 5, 10, 
                "Prépare tes affaires (sac, vêtements) pour le lendemain.", 
                "Affaires prêtes pour demain.")
        ))

        // --- SOCIAL ---
        quests.addAll(listOf(
            createQuest("Signal de Vie", QuestCategory.SOCIAL, Difficulty.MICRO, 1, 5, 
                "Envoie un message sympa à un ami ou un proche.", 
                "Message envoyé."),
            createQuest("Connexion Vocale", QuestCategory.SOCIAL, Difficulty.STANDARD, 10, 20, 
                "Appelle quelqu'un au lieu d'envoyer un message.", 
                "Appel passé."),
            createQuest("Compliment Sincère", QuestCategory.SOCIAL, Difficulty.MINI, 1, 10, 
                "Fais un compliment honnête à quelqu'un aujourd'hui.", 
                "Compliment donné."),
            createQuest("Écoute Active", QuestCategory.SOCIAL, Difficulty.STANDARD, 0, 20, 
                "Lors d'une conversation, écoute sans interrompre ni préparer ta réponse.", 
                "Une conversation menée avec pleine attention."),
            createQuest("Acte de Bonté", QuestCategory.SOCIAL, Difficulty.BOSS, 0, 50, 
                "Rends service à quelqu'un sans rien attendre en retour.", 
                "Service rendu.")
        ))

        // --- SLEEP ---
        quests.addAll(listOf(
            createQuest("Couvre-feu Digital", QuestCategory.SLEEP, Difficulty.STANDARD, 0, 25, 
                "Aucun écran 23h soir.", // Assuming 30 mins before bed, specific time makes it clearer
                "Ecrans éteints à 23h."),
            createQuest("Sanctuaire de Repos", QuestCategory.SLEEP, Difficulty.MINI, 5, 10, 
                "Aère ta chambre 5 minutes avant de dormir.", 
                "Chambre aérée et fraîche."),
            createQuest("Routine Nocturne", QuestCategory.SLEEP, Difficulty.MINI, 10, 15, 
                "Prépare-toi à dormir (dents, pyjama) 30 min avant l'heure cible.", 
                "Prêt à dormir en avance."),
            createQuest("Réveil de Précision", QuestCategory.SLEEP, Difficulty.STANDARD, 0, 25, 
                "Lève-toi dès la première sonnerie (pas de snooze).", 
                "Debout sans reporter l'alarme."),
            createQuest("Huit Heures de Stase", QuestCategory.SLEEP, Difficulty.BOSS, 0, 50, 
                "Dors au moins 7h30 ou 8h cette nuit.", 
                "8 heures de sommeil atteintes.")
        ))

        return quests
    }

    private fun createQuest(
        title: String, 
        category: QuestCategory, 
        difficulty: Difficulty, 
        duration: Int, 
        xp: Int, 
        instructions: String,
        successCriteria: String
    ): Quest {
        return Quest(
            id = UUID.randomUUID().toString(),
            title = title,
            category = category,
            difficulty = difficulty,
            durationMinutes = duration,
            xpReward = xp,
            instructions = instructions,
            successCriteria = successCriteria,
            isCompleted = false
        )
    }
}
