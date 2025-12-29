package com.soloxp.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0010\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\'J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/soloxp/data/local/SoloXpDao;", "", "getAllQuests", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/soloxp/data/local/entity/QuestEntity;", "getUserProfile", "Lcom/soloxp/data/local/entity/UserProfileEntity;", "insertQuest", "", "quest", "(Lcom/soloxp/data/local/entity/QuestEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserProfile", "profile", "(Lcom/soloxp/data/local/entity/UserProfileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface SoloXpDao {
    
    @androidx.room.Query(value = "SELECT * FROM quests ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.soloxp.data.local.entity.QuestEntity>> getAllQuests();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertQuest(@org.jetbrains.annotations.NotNull()
    com.soloxp.data.local.entity.QuestEntity quest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM user_profile WHERE id = \'local_user\'")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.soloxp.data.local.entity.UserProfileEntity> getUserProfile();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateUserProfile(@org.jetbrains.annotations.NotNull()
    com.soloxp.data.local.entity.UserProfileEntity profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}