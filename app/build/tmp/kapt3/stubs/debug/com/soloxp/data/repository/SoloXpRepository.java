package com.soloxp.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH&J\u0010\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bH&J\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/soloxp/data/repository/SoloXpRepository;", "", "addQuest", "", "quest", "Lcom/soloxp/domain/model/Quest;", "(Lcom/soloxp/domain/model/Quest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQuests", "Lkotlinx/coroutines/flow/Flow;", "", "getUserProfile", "Lcom/soloxp/domain/model/UserProfile;", "saveUserProfile", "profile", "(Lcom/soloxp/domain/model/UserProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface SoloXpRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.soloxp.domain.model.Quest>> getQuests();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addQuest(@org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.Quest quest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.soloxp.domain.model.UserProfile> getUserProfile();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveUserProfile(@org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.UserProfile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}