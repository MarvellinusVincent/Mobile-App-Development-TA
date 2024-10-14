package com.example.practicum12.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/example/practicum12/database/TicketTypeConverter;", "", "()V", "fromDate", "", "date", "Ljava/util/Date;", "fromUUID", "", "id", "Ljava/util/UUID;", "toDate", "millisSinceEpoch", "toUUID", "idString", "app_debug"})
public final class TicketTypeConverter {
    
    public TicketTypeConverter() {
        super();
    }
    
    @androidx.room.TypeConverter
    public final long fromDate(@org.jetbrains.annotations.NotNull
    java.util.Date date) {
        return 0L;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.util.Date toDate(long millisSinceEpoch) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.lang.String fromUUID(@org.jetbrains.annotations.NotNull
    java.util.UUID id) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID toUUID(@org.jetbrains.annotations.NotNull
    java.lang.String idString) {
        return null;
    }
}