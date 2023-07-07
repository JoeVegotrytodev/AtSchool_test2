Feature: Создание производных элементов
  Scenario Outline: создание производных элементов
    Given Получаем элементы для создания нового <element1> <element2>
    When Соединение элементов
    Then Создан требуемый элемент <newElement>

    Examples:
      | element1 | element2 | newElement |
      | "Air"    | "Air"    | "Pressure" |
      | "Air"    | "Earth"  | "Dust"     |
      | "Air"    | "Fire"   | "Energy"   |
      | "Air"    | "Water"  | "Rain"     |
      | "Earth"  | "Earth"  | "Pressure" |
      | "Earth"  | "Air"    | "Dust"     |
      | "Earth"  | "Water"  | "Mud"      |
      | "Earth"  | "Fire"   | "Lava"     |
#    | "Fire"   | "Fire"    | "Lava"    |
      | "Fire"   | "Air"    | "Energy"   |
      | "Fire"   | "Water"  | "Steam"    |
      | "Fire"   | "Earth"  | "Lava"     |
      | "Water"  | "Water"  | "Sea"      |
      | "Water"  | "Air"    | "Rain"     |
      | "Water"  | "Earth"  | "Mud"      |
      | "Water"  | "Fire"   | "Steam"    |