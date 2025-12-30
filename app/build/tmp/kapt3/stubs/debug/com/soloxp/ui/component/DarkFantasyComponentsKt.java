package com.soloxp.ui.component;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000R\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u001aB\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u000e\b\u0002\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007\u001a4\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010#\u001a\u00020$2\u000e\b\u0002\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010+\u001a\u00020&H\u0007\u001a.\u0010,\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020$H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010/\u001a&\u00100\u001a\u00020\u001e2\u001c\u00101\u001a\u0018\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001e02\u00a2\u0006\u0002\b4\u00a2\u0006\u0002\b5H\u0007\u001a.\u00106\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020$H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u0010/\u001aZ\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020&2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010:\u001a\u00020\u00022\u001c\u00101\u001a\u0018\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u001e02\u00a2\u0006\u0002\b4\u00a2\u0006\u0002\b5H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010=\u001a\u001c\u0010>\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010 H\u0007\u001a\u0018\u0010@\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020 H\u0007\u001a.\u0010C\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020$H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bD\u0010/\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u0013\u0010\t\u001a\u00020\u0002\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0004\"\u0013\u0010\r\u001a\u00020\u0002\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007\"\u0013\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007\"\u0013\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007\"\u0013\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007\"\u0013\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007\"\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0004\"\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0004\"\u0013\u0010\u001b\u001a\u00020\u0002\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006E"}, d2 = {"CyanGradient", "", "Landroidx/compose/ui/graphics/Color;", "getCyanGradient", "()Ljava/util/List;", "DarkGrey", "getDarkGrey", "()J", "J", "DeepBlack", "getDeepBlack", "GoldGradient", "getGoldGradient", "MidGrey", "getMidGrey", "NeonCyan", "getNeonCyan", "NeonGold", "getNeonGold", "NeonPurple", "getNeonPurple", "NeonRed", "getNeonRed", "PurpleGradient", "getPurpleGradient", "RedGradient", "getRedGradient", "SoftGlow", "getSoftGlow", "ActionButton", "", "text", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "gradient", "AnimatedProgressBar", "progress", "", "showPercentage", "BodyText", "color", "BodyText-bw27NRU", "(Ljava/lang/String;JLandroidx/compose/ui/Modifier;)V", "DarkFantasyBackground", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DisplayText", "DisplayText-bw27NRU", "GlassCard", "isSelected", "glowColor", "Landroidx/compose/foundation/layout/ColumnScope;", "GlassCard-42QJj7c", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function1;)V", "LargeHeader", "subtext", "SummaryRow", "label", "value", "TitleText", "TitleText-bw27NRU", "app_debug"})
public final class DarkFantasyComponentsKt {
    private static final long NeonCyan = 0L;
    private static final long NeonGold = 0L;
    private static final long NeonPurple = 0L;
    private static final long NeonRed = 0L;
    private static final long DeepBlack = 0L;
    private static final long DarkGrey = 0L;
    private static final long MidGrey = 0L;
    private static final long SoftGlow = 0L;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<androidx.compose.ui.graphics.Color> CyanGradient = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<androidx.compose.ui.graphics.Color> GoldGradient = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<androidx.compose.ui.graphics.Color> PurpleGradient = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<androidx.compose.ui.graphics.Color> RedGradient = null;
    
    public static final long getNeonCyan() {
        return 0L;
    }
    
    public static final long getNeonGold() {
        return 0L;
    }
    
    public static final long getNeonPurple() {
        return 0L;
    }
    
    public static final long getNeonRed() {
        return 0L;
    }
    
    public static final long getDeepBlack() {
        return 0L;
    }
    
    public static final long getDarkGrey() {
        return 0L;
    }
    
    public static final long getMidGrey() {
        return 0L;
    }
    
    public static final long getSoftGlow() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<androidx.compose.ui.graphics.Color> getCyanGradient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<androidx.compose.ui.graphics.Color> getGoldGradient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<androidx.compose.ui.graphics.Color> getPurpleGradient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<androidx.compose.ui.graphics.Color> getRedGradient() {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DarkFantasyBackground(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super androidx.compose.foundation.layout.BoxScope, kotlin.Unit> content) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LargeHeader(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.Nullable()
    java.lang.String subtext) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ActionButton(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, boolean enabled, @org.jetbrains.annotations.NotNull()
    java.util.List<androidx.compose.ui.graphics.Color> gradient) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SummaryRow(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AnimatedProgressBar(float progress, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    java.util.List<androidx.compose.ui.graphics.Color> gradient, boolean showPercentage) {
    }
}