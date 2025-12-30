package com.soloxp.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/soloxp/data/local/SoloXpDatabase;", "Landroidx/room/RoomDatabase;", "()V", "dao", "Lcom/soloxp/data/local/SoloXpDao;", "itemDao", "Lcom/soloxp/data/local/dao/ItemDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.soloxp.data.local.entity.QuestEntity.class, com.soloxp.data.local.entity.UserProfileEntity.class, com.soloxp.data.local.entity.ItemEntity.class}, version = 5)
public abstract class SoloXpDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_2_3 = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_3_4 = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_4_5 = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.soloxp.data.local.SoloXpDatabase.Companion Companion = null;
    
    public SoloXpDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.soloxp.data.local.SoloXpDao dao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.soloxp.data.local.dao.ItemDao itemDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/soloxp/data/local/SoloXpDatabase$Companion;", "", "()V", "MIGRATION_2_3", "Landroidx/room/migration/Migration;", "getMIGRATION_2_3", "()Landroidx/room/migration/Migration;", "MIGRATION_3_4", "getMIGRATION_3_4", "MIGRATION_4_5", "getMIGRATION_4_5", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGRATION_2_3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGRATION_3_4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGRATION_4_5() {
            return null;
        }
    }
}