# Implementation Plan - Phase 8: Detailed Quest View

Enhance the Quest system to provide clear instructions and success criteria, helping users understand exactly what to do.

## User Review Required
> [!IMPORTANT]
> **Database Update**: This change requires a schema migration (Version 2 -> 3) to add the `successCriteria` column to the `quests` table.

## Proposed Changes

### Data Layer
#### [MODIFY] [Models.kt](file:///Users/kevingachie/Desktop/Antigravity/SoloXP/app/src/main/java/com/soloxp/domain/model/Models.kt)
- Add `successCriteria: String` to `Quest` data class.

#### [MODIFY] [Entities.kt](file:///Users/kevingachie/Desktop/Antigravity/SoloXP/app/src/main/java/com/soloxp/data/local/entity/Entities.kt)
- Add `successCriteria: String` to `QuestEntity`.

#### [MODIFY] [SoloXpDatabase.kt](file:///Users/kevingachie/Desktop/Antigravity/SoloXP/app/src/main/java/com/soloxp/data/local/SoloXpDatabase.kt)
- Increment version to 3.
- Add AutoMigration spec.

#### [MODIFY] [SeedData.kt](file:///Users/kevingachie/Desktop/Antigravity/SoloXP/app/src/main/java/com/soloxp/data/local/SeedData.kt)
- Update `getInitialQuests` to include explicit success criteria for each quest (e.g., "Verre vidé", "10 respirations effectuées").

### UI Layer
#### [MODIFY] [DungeonScreen.kt](file:///Users/kevingachie/Desktop/Antigravity/SoloXP/app/src/main/java/com/soloxp/ui/screen/DungeonScreen.kt)
- Update `QuestCard` to be clickable (distinct from the "Fixer/Complete" button).
- **New Component**: `QuestDetailSheet` (ModalBottomSheet) or similar dialog.
- Display:
  - Title (Large)
  - Instructions (Body)
  - **Success Criteria** (Checklist style)
  - Rewards (XP/Loot chance)

## Verification Plan
### Manual Verification
- **Migration**: Verify app launches without crashing on update.
- **UI**: Click a quest card -> Detail view appears -> content matches seed data.
